var month = 0;

function calcSalary()
{
    var salForm = document.getElementsByName("sal");
    var monthCounts = 3;

    var count;
    var averageSalary = 0;
    for(count = 0; count < salForm.length && count < monthCounts; count++)
    {
        averageSalary += parseInt(salForm[count].value);
    }
    averageSalary /= count;
    var salaryField = document.getElementById("salaryVal");
    salaryField.innerHTML = averageSalary.toFixed(3);
    var description = document.getElementById("description");
    description.innerHTML = " Rubles for last " + count + " month";
}

function addForm()
{
    month++;
    var button = document.getElementById("btn");
    var div = document.createElement("div");
    div.innerHTML = '<br>' + '<span>Month ' + month + ': </span>';
    var form = '<input name="sal" type="number" value="0" size="10" onblur="calcSalary()">'; 
    div.innerHTML += form;

    button.after(div);
}
