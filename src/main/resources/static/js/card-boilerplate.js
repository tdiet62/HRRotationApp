var cardCreator = (function(){
    var newElement = function(tag,clazz){
        return $("<"+tag+" class='"+clazz+"'></"+tag+">");
    }

    var newCardColumn = function(item){
        return newElement('div','assignment-column')
            .attr('id','assignment-'+item.roleId)
            .append(newCard(item))
            .on('click', function(){
                appController.showDetails(item.roleId);
            });
    }

    var newCard = function(item){
        return newElement('div','card card-block card-primary card-inverse assignment-card')
            .append(newCardHeader('Skill',item.skill))
            .append(newCardBlock(item))
            .append(newCardFooter('Level of Clearance',item.levelOfClearance));
    }

    var newCardHeader = function(label,text){
        return newElement('h3','card-header assignment-title')
            .append(newTextDiv(text))
            .prepend(newLabel(label));
    }

    var newCardBlock = function(item){
        return newElement('div','card-block inner-card')
            .append(newCardText('Location',item.location))
            .append(newCardText('Resource Manager',item.resourceManager))
            .append(newCardText('Minimum Grade',item.minimumGrade))
            .append(newCardText('Maximum Grade',item.maximumGrade));
    }

    var newCardText = function(label,text){
        return newElement('p','card-text')
            .append(newTextDiv(text))
            .prepend(newLabel(label));
    }

    var newTextDiv = function(text){
        return newElement('div','assignment-data')
            .text(text);
    }

    var newCardFooter = function(label,text){
        return newElement('h3','card-footer')
            .append(newTextDiv(text))
            .prepend(newLabel(label));
    }

    var newLabel = function(label){
        return newElement('sup','alabel').text(label);
    }

    //END OF ITEM CARD BOILER PLATE

    var newDetailCardColumn = function(item){
        return newElement('div','detail-card')
            .append(newDetailCard(item));
    }

    var newDetailCard = function(item){
        return newElement('div','card card-block card-primary card-inverse assignment-card')
            .append(newDetailCardHeader('Skill',item.skill))
            .append(newDetailCardBlock(item))
            .append(newCardFooter('Level of Clearance',item.levelOfClearance));
    }

    var newDetailCardHeader = function(label,text){
        return newElement('h3','card-header assignment-title')
            .append(newTextDiv(text))
            .prepend(newLabel(label));
    }

    var newButtonDiv = function(text,fn){
        return newElement('div','card-text')
            .append(newElement('button','btn btn-danger right').attr('id','hide-details-button').attr('type','button').click(fn).text(text));
    }

    var newDetailCardBlock = function(item){
        return newElement('div','card-block inner-card')
            .append(newButtonDiv('Hide Details',function(){appController.hideDetails()}))
            .append(newCardText('Location',item.location))
            .append(newCardText('Resource Manager',item.resourceManager))
            .append(newCardText('Minimum Grade',item.minimumGrade))
            .append(newCardText('Maximum Grade',item.maximumGrade))
            .append(newCardText('Delivery Unit',item.deliveryUnit))
            .append(newCardText('Role ID',item.roleId))
            .append(newCardText('Client Project',item.clientProject))
            .append(newCardText('Current Start Date',item.currentStartDate))
            .append(newCardText('Current End Date',item.currentEndDate))
            .append(newCardText('Role Description',item.roleDescription));
    }

    return {
        createCard : function(item){
            return newCardColumn(item)
        },
        createDetailCard: function(item){
            return newDetailCardColumn(item);
        }
    }
})()
