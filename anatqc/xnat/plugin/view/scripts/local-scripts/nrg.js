dojo.ready(function()
{
    dojo.require("dojox.timing");
    dojo.require("dojo.data.ItemFileReadStore");

    dojo.provide("nrg.XnatStore");
    dojo.declare("nrg.XnatStore", dojo.data.ItemFileReadStore,
    {
        _getItemsFromLoadedData: function(data)
        {
            data.identifier="ID";
            data.items = data.ResultSet.Result;
            this.inherited(arguments);
        }
    });
});

var nrg = {
    /**
     * Red highlight
     */
    RED: "#CE4F4F",

    /**
     * Gray highlight
     */
    GRAY: "#808080",

    /**
     * Smoke white
     */
    SMOKE: "#F5F5F5",

    /**
     * White
     */
    WHITE: "#FFF",

    /**
     * Return unique items from array
     *
     * @param array arr
     * @return array
     */
    unique: function(arr)
    {
        var test = new Array()
        var uniqued = new Array();

        dojo.forEach(arr, function(item) {
            if(!test[item])
            {
                test[item] = true; 
                uniqued.push(item);
            }
        }); 
        
        return(uniqued);
    },

    sortSelect: function(s,wrap)
    {
        var options=[];
        var prepend=null;
        var append=null;

        for (var i=0;i<s.options.length;++i)
        {
            if (wrap && s.options[i].innerHTML=="(SELECT)")
                prepend=s.options[i];
            else
            if (wrap && s.options[i].innerHTML=="Custom")
                append=s.options[i];
            else
                options.push(s.options[i]);
        }


        options.sort(this.optionSort);

        var i=0;

        if (prepend)
            s.options[i++]=prepend;

        for (var j=0;j<options.length;++j)
            s.options[i++]=options[j];

        if (append)
            s.options[i]=append;
    },

    optionSort: function(a,b)
    {
        return a.innerHTML.localeCompare(b.innerHTML);
    },

    /**
     * Prepend items to select box
     * 
     * @param array items
     */
    prepend: function(items)
    {
        var i = 0;
        var temp = new Array();

        if (typeof(this['unique'])=="undefined")
            this.unique={};

        // preserve (SELECT) as the first Option
        if(this.options.length)
            temp.push(this.options.item(0));

        // add the new elements
        if(items instanceof Array)
        {
            for(var i = 0; i < items.length; ++i)
            {
                if (!items[i].innerHTML.length)
                    continue;

                if (typeof(this.unique[items[i].value])=="undefined") 
                {
                    temp.push(items[i]);
                    this.unique[items[i].value]=true;
                }
            }
        }
        else
        {
            if (items.innerHTML.length && typeof(this.unique[items.value])=="undefined") 
            {
                temp.push(items);
                this.unique[items.value]=true;
            }
        }

        // preserve all other Options in a temporary array
        for(var i = 1; i < this.options.length; ++i)
        {
            var item=this.options.item(i);

            //Search for this item in the temp array
            var found=false;
            dojo.forEach(temp,function(obj) {
                    if (obj.innerHTML==item.innerHTML)
                        found=true;
            });

            if (item.innerHTML.length && !found)
            {
                temp.push(item);
                this.unique[item.value]=true;
            }
        }


        var old_onchange=this.onchange;
        this.onchange=null;

        // add (overwrite) existing options in the right order
        for(var i = 0; i < temp.length; ++i)
            this.options[i] = temp[i];

        this.onchange=old_onchange;
    },

    /**
     * Set visibility of div
     */
    setVisibility: function()
    {
        if(trigger)
        {
            if(trigger == this.value)
                child.style.display = 'table-row';
            else if(trigger != this.value)
                child.style.display = 'none';
        }
        else
        {
            var currVis = child.style.display;
            if(currVis == 'table-row')
            {
                child.style.display = 'none';
                par.innerHTML = "<img src='/images/plus.gif'/>";	
            }
            else if(currVis == 'none')
            {
                child.style.display = 'table-row';
                par.innerHTML = "<img src='/images/minus.jpg'/>";	
            }
        }
    },

    /**
     * Populate select box with data from custom Restlet
     * 
     * @param domnode select
     * @param string field
     */
    populateSelect: function(select, field)
    {
        var url = "/REST/";

        url += field + "s";

        dojo.xhrGet({
                    url: url + "?format=json",
                    handleAs: "json",
                    load: function(data, ioargs)
                    {
                        select.options.length = 0;
                        nrg.populateSelectJson(data.ResultSet.Result, select, field);
                    },
                    error: function(err, ioargs)
                    {
                        nrg.toast("Oops... failed to retrieve a list of " + field + "s from XNAT.");
                    }
        });
    },

    /**
     * Populate select box with data from default Restlet
     *
     * @param domnode select
     * @param str xsitype
     * @param str column
     */
    populateSelect2: function(select, xsi_type, column)
    {
        var url = "/REST/experiments?xsiType=" + xsi_type + "&columns=" + column;

        dojo.xhrGet({
                        url: url + "&format=json",
                        handleAs: "json",
                        load: function(data, ioargs)
                        {
                            select.options.length = 0;
                            nrg.populateSelectJson(data.ResultSet.Result, select, column);
                        },
                        error: function(err, ioargs)
                        {
                            nrg.toast("Oops... failed to retrieve a list of " + column + "s from XNAT");
                        }
        });
    },

    /**
     * Populate select box from JSON data returned from REST request
     */
    populateSelectJson: function(items, select, field)
    {
        var itemNames = new Array();
        var defaultValueField = dojo.byId(select.id + "-default");
        var defaultValue = null;

        if(defaultValueField)
            defaultValue = defaultValueField.innerHTML;

        select.prepend = nrg.prepend;

        var unique = new Array();
        for(var i = 0; i < items.length; ++i)
        {
            if(!items[i][field].length)
                continue;

            if(!unique[items[i][field]])
            {
                itemNames.push(new Option(items[i][field], items[i][field]));
                unique[items[i][field]] = true;
            }
        }

        itemNames.sort(function(a, b)
        {
            var str1 = a.value;
            var str2 = b.value;
            return ( ( str1 == str2 ) ? 0 : ( ( str1 > str2 ) ? 1 : -1 ) );
        });

        itemNames.unshift(new Option('(SELECT)', ''));
        itemNames.push(new Option('Custom', 'Custom'));
        select.prepend(itemNames);

        // save the old selectedIndex in the event that the user clicks 'Cancel' i.e., to restore previous selectIndex
        select.onclick = function()
        {
            select.previousIndex = select.selectedIndex;
        }

        // prompt user for "Custom" selectbox value
        select.onchange = function(obj)
        {
            nrg.checkIndex.apply(select);

            if(select.value == "Custom")
            {
                var text = prompt("Custom " + field);
                
                if(text)
                {
                    text = dojo.trim(text);
                    var found = false;

                    // search for an existing Option
                    for(var i = 0; i < select.options.length; ++i)
                    {
                        if(select.options[i].value == text)
                        {
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        select.prepend(new Option(text, text));
                        select.selectedIndex = 1;
                    }
                }
                else
                    select.selectedIndex = select.previousIndex;
            }
        }

        if(defaultValue != null)
        {
            for(var i = 0; i < select.options.length; ++i)
            {
                if(defaultValue == select.options[i].value)
                {
                    select.selectedIndex = i;
                    break;
                }
            }
        }
    },

    /**
     * Check selectbox index and highlight if index == 0
     */
    checkIndex: function()
    {
        if(this.selectedIndex == 0)
            nrg.toggleHighlight(this, "red");
        else
            nrg.toggleHighlight(this, "grey");
    },

    /**
     * Check entered MR Session label against all pre-existing labels
     */
    checkMrSession: function()
    {
        var txtbox = dijit.byId("xnat:mrSessionData/label");

        dojo.xhrGet({
            url: "/api/MrSession/id?label=" + txtbox.value,
            handleAs: "json",
            load: function(data, ioargs) {
                if(dojo.isArray(data.values) && data.values.length != 0)
                {
                    txtbox.attr("value", "").focus();
                    txtbox.displayMessage("MR Session label already exists");
                } 
            },
            error: function(err, ioargs) {
                nrg.toast("Oops... could not determine if MR Session label is in use");
            }
        });
    },

    /**
     * Toggle node border color and width
     */
    toggleHighlight: function(node, color)
    {
        if(color.toLowerCase() == "red")
        {
            node.style.borderColor = nrg.RED;
            node.style.borderWidth = "2px";
        }
        else if(color.toLowerCase() == "gray" || color.toLowerCase() == "grey")
        {
            node.style.borderColor = nrg.GRAY;
            node.style.borderWidth = "1px";
        }
    },

    /**
     * Validate the ImageSession edit form
     *
     * @param e: event
     */
    validateImageSessionForm: function(e)
    {
        var valid = dijit.byId("form1").validate();

        dojo.query("select").forEach(function(node) {
            dojo.connect(node, "onchange", nrg.checkIndex);
            
            if(node.selectedIndex == 0)
            {
                nrg.toggleHighlight(node, "red");
                valid = false;
            }
        });

        // prevent event default action
        if(! valid && e != undefined)
            e.preventDefault();

        return valid;
    },

    /**
     * Show/hide "language" textbox
     */
    showHideLangBox: function(e)
    {
        var natLang = dojo.byId("xnat:subjectData/demographics[@xsi:type=xnat:demographicData]/english");
     
        if(natLang.value != "Yes")
            dojo.style("lang_span", "display", "table-row");
        else
            dojo.style("lang_span", "display", "none");
    },

    /**
     * Validate the SubjectData form
     */
    validateSubjectDataForm: function(e)
    {
        var valid = dijit.byId("editSubjectForm").validate();

        dojo.query("select").forEach(function(node) {
            dojo.connect(node, "onchange", nrg.checkIndex);

            if(node.selectedIndex == 0)
            {
                // special case, tested in validateAgeFields()
                if(node.id == "xnat:subjectData/demographics[@xsi:type=xnat:demographicData]/yob")
                    return;

                nrg.toggleHighlight(node, "red");
                valid = false;
            }
        });

        var validAges = nrg.validateAgeFields();

        valid = valid && validAges;

        // prevent event default action
        if(! valid && e != undefined)
        {
            if(!confirm("Form has errors. Continue?"))
                e.preventDefault();
        }
        
        return valid;
    },

    /**
     * Validate age, yob, dob fields
     */
    validateAgeFields: function()
    {
        var valid = true;

        var dobField = dojo.byId("xnat:subjectData/demographics[@xsi:type=xnat:demographicData]/dob");
        var yobField = dojo.byId("xnat:subjectData/demographics[@xsi:type=xnat:demographicData]/yob");
        var ageField = dojo.byId("xnat:subjectData/demographics[@xsi:type=xnat:demographicData]/age");

        if(dojo.byId("dob").checked)
        {
            if(dojo.trim(dobField.value) == "")
                valid = false;
        }
        else
            dobField.value = "NULL";

        if(dojo.byId("yob").checked)
        {
            if(yobField.selectedIndex == 0)
            {
                nrg.toggleHighlight(yobField, "red");
                valid = false;
            }
        }
        else
        {
            yobField.selectedIndex = 0;
            nrg.toggleHighlight(yobField, "grey");
        }

        if(dojo.byId("age").checked)
        {
            if(dojo.trim(ageField.value) == "")
                valid = false;
        }
        else
            ageField.value = "NULL";

        return valid;
    },

    /**
     * Sleep function
     *
     * @param ms: int
     */
    sleep: function(ms)
    {
        var startTime = new Date().getTime();
        
        while(new Date().getTime() < startTime + ms);
    },


     /**
      * Create a "toast" message
      *
      * @param message: string
      * @param duration: int milliseconds
      */
     toast: function(message, duration)
     {
         // no message means no toast
         if(message == undefined || dojo.trim(message) == "")
             return;

         // default duration 5000 ms
         duration = typeof(duration) != 'undefined' ? duration : 5000;

         // create toast container if necessary and fixed to the body
         var toast_container = dojo.byId("toast_container");
         if(toast_container == null)
         {
            toast_container = dojo.create("div", {"id": "toast_container", "style": {"textAlign": "center", "width": "100%", "position": "fixed", "top": "0px"}}, dojo.body());
         }

         var toast_style = {
                         "margin": "0 auto",
                         "display": "inline-block",
                         "opacity": "0",
                         "maxWidth": "500px",
                         "wordWrap": "break-word",
                         "whiteSpace": "normal",
                         "borderRight": "1px solid #FFE475",
                         "borderLeft": "1px solid #FFE475",
                         "borderBottom": "1px solid #FFE475",
                         "padding": "6px 10px",
                         "background": "#FEF7CB",
                         "borderBottomLeftRadius": "2px",
                         "borderBottomRightRadius": "2px",
                         "fontWeight": "bold",
                         "fontSize": "13px",
                         "fontColor": "black",
                         "textAlign": "center"
         }
   
         // destroy any stale toast
         if(dojo.byId("toast") != null)
         {
             dojo.byId("toast").timer.stop();
             dojo.destroy("toast");
         }

         // create the toast div and attach it to the container
         dojo.create("div", {"id": "toast", "style": toast_style, innerHTML: message}, toast_container);

         dojo.fadeIn({"node": "toast", "duration": 1000}).play();
        
         // create a timer on the toast element
         dojo.byId("toast").timer = new dojox.timing.Timer(duration);

         dojo.byId("toast").timer.onTick = function()
         {
             // stop timer and fade out the message
             this.stop();

             // prevent provoking error from race condition
             if(dojo.byId("toast_container"))
                dojo.fadeOut({"node": "toast", "duration": 1000, "onEnd": function(){dojo.destroy("toast_container")}}).play();
         }

         // start the timer
         dojo.byId("toast").timer.start();
     },

    /**
     * Download a list of and,optionally, filters the assessor files/resources of a given experiment
     *
     * To query for all existing files associated with the experiment's assessor, supply a JSON object, as such:
     *  { 
     *      project: 'x', //the project
     *      subject: 'y', //the subject label or id
     *      experiment:'z',//the mr session label or id
     *      assessor: 'w', //the assessor
            success: function(result) { console.log(result); }, //the success function
            failure: function(type,request) { console.log(type,request); } //optional, the failure function
     *  }
     *
     * To query for all resources (existing on disk or not) associated with an assessor, supply a JSON object like so:
     *  {
     *      experiments: 'x',   //WARNING: this MUST be the ID of the mrsession, NOT the label.
     *      assessor:'y',
     *      resources:true,
     *      filename: 'foo.xml', //an optional filename to append to all URI's built by this function
     *      success: function (result) { console.log(result); },
     *      failure: function(type,request) { console.log(type,request); }
     *  }
     *      
     * To filter the results, use the "filter" property:
     *  {
     *      ... ,
     *      filter: {       //the filter is optional 
     *                  Name: /K.xml$/,  //each filter property can be either a string, a regex or a function
     *                  label: "xml"
     *               },
     *  }
     */
    getAssessorFileURL: function(params)
    {
        var url = "/data/";

        if (params==undefined)
            throw "'params' is a required parameter";

        if (typeof(params['resources'])!="undefined")
        {
            url+="experiments/"+params.experiment+"/assessors/"+params.assessor;
            url+="/out/resources";
        }
        else
        {
            url+="projects/"+params.project+"/subjects/"+params.subject+"/experiments/"+params.experiment+"/assessors/"+params.assessor;
            url+="/files";
        }

        dojo.xhrGet({
                    url: url + "?format=json",
                    handleAs: "json",
                    load: function(response, ioargs)
                    {
                        if (response===undefined || response.ResultSet===undefined || response.ResultSet.Result===undefined)
                            if (params.failure!==undefined && typeof(params.failure)=="function")
                                return params.failure("EMPTY_RESPONSE",data);

                        var list=response.ResultSet.Result;
                        var result=[];

                        if (params.filter!==undefined)
                            result=nrg.filter(list,params.filter);
                        else
                            result=list;

                        //Build the file URI by hand
                        if (typeof(params['resources'])!="undefined")
                        {
                            for (var i=0;i<result.length;++i)
                            {
                                result[i].URI=url+"/"+result[i].xnat_abstractresource_id;

                                if (typeof(params.filename)!==undefined)
                                    result[i].URI+="/files/"+params.filename.replace(/\\/,'').replace(/.*\//,'');
                            }
                        }

                        if (params.success!==undefined && typeof(params.success)=="function")
                            params.success(result);
                    },
                    error: function(err, ioargs)
                    {
                        if (params.failure!==undefined && typeof(params.failure)=="function")
                            params.failure("NETWORK", err);
                    }
        });
    },

    /** Filters an array of objects using a filter
    * Example: nrg.filter([{a:1,b:'foo'],{b:/^fo/});
    * @return Array - A new array containing only objects that made it through the filter
    */
    filter: function(list,filter)
            {
                var result=[];

                if (list===undefined || filter===undefined)
                    return result;

                //iterate over the list to apply the filter
                for (var i=0; i<list.length; ++i)
                {
                    var obj=list[i];
                    var found=true;

                    //check the object properties against those is 'search'
                    for (var prop in filter)
                    {
                        var match=true;

                        if (typeof(obj[prop])=="undefined")    //check if property exists
                            match=false;
                        else
                        if (typeof(filter[prop])==="function") //run regex (Crome) or custom function
                        {
                            if (!filter[prop](obj[prop]))
                                match=false;
                        }
                        else
                        //Firefox support
                        if (filter[prop] instanceof RegExp)
                        {
                            if (!filter[prop].test(obj[prop]))
                                match=false;
                        }
                        else
                        if (obj[prop]!==filter[prop])          //strict comparison
                            match=false;

                        //if at least one property didn't match, don't check the rest of the props
                        if (!match)
                        {
                            found=false;
                            break;
                        }
                    }

                    //matched
                    if (found)
                    {
                        result.push(obj);
                    }
                }

                return result;
            },

   /**
    * Get file icon src
    *
    * @param type: str
    * @return: str
    */
    getFileIcon: function(type)
    {
        switch(type)
        {
            case "image/png":
                return "/images/image-icon.png";
            case "text/xml":
                return "/images/generic-icon.png";
            case "text/csv":
                return "/images/excel-icon.png";
            default:
                return "/images/generic-icon.png";
        }
    },

    /**
     * Build files widget
     * 
     * @param files: Array
     * @param dockId: string
     * @return: Array
     */
    createFilesWidget: function(files, dockId, label_field)
    {
        var table = dojo.create("table", {"width": "100%", "cellspacing": "0"});
        var titlePane = new dijit.TitlePane({"title": "Files", "content": table});
        
        if(label_field == undefined)
            label_field = "collection";
       
        if(files.length == 0)
        {
           nrg.toast("Oops... no assessor files returned to build files widget. Try again later.");
           titlePane.toggle();
        }

        titlePane.placeAt(dojo.byId(dockId));

        var row_color = "#F5F5F5";

        dojo.forEach(files, function(file, i) 
        {
            if(!file)
                return;

            var format = file.file_format;
            var icon = nrg.getFileIcon(format);
            var label = file[label_field].replace(":qc", "");
            var url = file.URI;

            var table_data = '<td style="padding: 4px; padding-right: 1px; width: 12px"><img src="' + icon + '"></img></td>' +
                             '<td><a id="' + label + '" href="' + url + '">' + label + '</a></td>';
            
            var table_row = dojo.create("tr", {}, table);
            table_row.innerHTML = table_data;

            if(format.match(/(png|gif|jpg)/))
            {
                var lightbox = new dojox.image.Lightbox({"title": label, "group": "group", "href": url}, dojo.byId(label)).startup();
                var tooltip = new dijit.TooltipDialog({content: '<img style="height: 90px" src="' + url + '" />'});
                dojo.connect(dojo.byId(label), "onmouseover",  function() {
                    dijit.popup.open({
                        popup: tooltip,
                        around: dojo.byId(label)
                    });
                });
                dojo.connect(dojo.byId(label), 'onmouseout', function() {
                    dijit.popup.close(tooltip);
                });
                dojo.connect(dojo.byId(label), 'onclick', function() {
                    dijit.popup.close(tooltip);
                });
            }
            else
                dojo.byId(label).href = url;

            dojo.style(table_row, "backgroundColor", row_color);
            
            if(row_color == "#F5F5F5")
                row_color = "#DAD9D8";
            else
                row_color = "#F5F5F5";
        });
        
        dojo.style(titlePane.containerNode, "overflow", "auto");
    }
}
