var month = 0;

function calcSalary()
{
    var salForm = document.getElementsByClassName("inputMoney");
    var monthCounts = 3;

    var count;
    var averageSalary = 0;

    for(count = 0; count < salForm.length && count < monthCounts; count++)
    {
        averageSalary += parseInt(salForm[count].value);
    }
    averageSalary /= count;

    var salaryField = document.getElementById("salaryVal");
    salaryField.innerHTML = averageSalary.toFixed(2);

    var description = document.getElementById("description");
    description.innerHTML = " for last " + count + " month";
}

function addForm()
{
    month++;
    var inputs = document.getElementById("firstInputs");
    var div = document.createElement("div");
    div.className = "inputDiv";
    div.innerHTML = '<span>Month ' + month + ': </span>';

    var form = '<input class="inputMoney" type="number" value="0" onblur="calcSalary()">'; 
    div.innerHTML += form;

    inputs.after(div);
}

function setCurrency()
{
    var selectList = document.getElementById("currencySelect");
    var curr = selectList.options[selectList.selectedIndex].text;

    var currField = document.getElementById("salaryCurrency");
    currField.innerHTML = curr;
}