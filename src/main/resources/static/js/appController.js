var appController = (function(dataCtrl,UICtrl){
    //1. load data

    var url = '/rest/person-requests/all';
    var queryData = function(){
        var payLoad;
        $.ajax({
            url:url,
            type:'GET',
            dataType:'json'
        }).then(
            function(resp){
                dataCtrl.setPayLoad(resp);//prime the dataController for sorting etc
                UICtrl.updateUI(resp);
            },
            function(){
                $('#no-data-warning').show();
            }
        )
    }


    var initialise = function(){
        queryData();
    }

    return{
        init:function(){initialise();},
        doSearch:function(event){
            UICtrl.updateUI(dataCtrl.doSearch(event))},
        showDetails: function(itemCode){
            UICtrl.showDetails(dataController.getItem(itemCode));
        },
        hideDetails: function(){
            UICtrl.hideDetails();
        },
        clearSearch: function(){UICtrl.clearSearch();}
    }

})(dataController,UIController);

appController .init();
