var UIController = (function(cardCreator){


    //1. Display data
    var updateUI = function(payLoadData){
        if(payLoadData.length>0){
            $('#no-data-warning').hide();
            $('#click-prompt').hide();
        }
        $('#click-prompt').show();

        deleteCards();
        payLoadData.forEach(function(item, index){
            var element = cardCreator.createCard(item);
            insertElement(element);
        })
        //attatchEvents();
    };

    var deleteCards = function(){
        removeEvents();
        $('.carousel-row').empty();
    }

    var removeEvents = function(){
        $("div[id^='assignment-']").each(
            function(i,j){
                $(j).off('click');
            }
        )
    }

    var showDetailsAnimated = function(item){
        $('#details-card').append(cardCreator.createDetailCard(item))
        $('#search-container').hide(400);
        $('#click-prompt').hide();
        $('#carousel-container').hide(400);
        $('#details-container').show(400);
    }


    var insertElement = function(element){
        $('.carousel-row').append(element);
    }

    var hideDetailsAnimated = function(){
        $('#details-container').hide(400);
        $('#search-container').show(400);
        $('#click-prompt').show();
        $('#carousel-container').show(400);
        $('#details-card').empty();
    }

    return{
        updateUI:       function(payLoadData){
                            updateUI(payLoadData);
                        },
        showDetails:    function(item){
            showDetailsAnimated(item);
        },
        hideDetails:    function(){
            hideDetailsAnimated();
        },
        clearSearch: function(){
            $('#searchTable')[0].value="";
            $('#searchTable').keyup();
            $('#searchTable').focus();
        }
    }

})(cardCreator);