var dataController = (function(){
    var requestPayload;

    var getSearchResults = function(event){
        var searchStringArray = event.target.value.split(" ");
        var filtered = requestPayload.filter(function(currentItem){
            var searchStringArrayClone = [].concat(searchStringArray);
            Object.keys(currentItem).forEach(function(currentKey){
                searchStringArray.forEach(function(searchTerm){
                    if(currentItem[currentKey].toLowerCase().includes(searchTerm.toLowerCase())){
                        var searchTermIndex=searchStringArrayClone.indexOf(searchTerm);
                        if(searchTermIndex > -1){
                            searchStringArrayClone.splice(searchTermIndex, 1);
                        }
                    }
                })
            })
            return searchStringArrayClone.length === 0;
        })
        return filtered;
    }

    var findItem = function(itemCode){
        var foundItem
        requestPayload.forEach(function(item){
            if(item.roleId === itemCode){
                foundItem=item;
            }
        })
        return foundItem;
    }

    return {
        getData: function(){
            $.ajax({
                url:url,
                type:'GET',
                dataType:'json'
            });
        },
        setPayLoad:function(payLoad){
            requestPayload=payLoad;
        },
        doSearch:function(event){
            return getSearchResults(event);
        },
        getItem: function(itemCode){
            return findItem(itemCode);
        }
    }
})();