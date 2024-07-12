document.getElementById('calculate').addEventListener('click', function() {
    const birthdate = new Date(document.getElementById('birthdate').value);
    const height = parseFloat(document.getElementById('height').value);
    const weight = parseFloat(document.getElementById('weight').value);

    if (!birthdate || isNaN(height) || isNaN(weight)) {
        alert('Please fill in all fields correctly.');
        return;
    }

    const age = calculateAge(birthdate);
    const bmi = calculateBMI(height, weight);

    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `Age: ${age} years<br>BMI: ${bmi.toFixed(2)}`;
});

function calculateAge(birthdate) {
    const today = new Date();
    let age = today.getFullYear() - birthdate.getFullYear();
    const monthDifference = today.getMonth() - birthdate.getMonth();
    if (monthDifference < 0 || (monthDifference === 0 && today.getDate() < birthdate.getDate())) {
        age--;
    }
    return age;
}

function calculateBMI(height, weight) {
    return weight / ((height / 100) ** 2);
}
