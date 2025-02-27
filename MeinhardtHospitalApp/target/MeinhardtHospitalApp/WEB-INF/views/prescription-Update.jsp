<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Prescription</title>
</head>
<body>
    <h1>Update Prescription</h1>
    <form action="/prescription/update" method="post">
        <input type="hidden" name="_method" value="put">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${prescriptionObj.name}" required>
       	<br>
        
        <label for="dosage">Dosage:</label>
        <input type="number" id="dosage" name="dosage" value="${prescriptionObj.dosage}" required>
        <br>
        
        <label for="registerDate">Register Date:</label>
        <input type="date" id="registerDate" name="registerDate" value="${prescriptionObj.registerDate}" required>
        <br>
        
        <label for="expiryDate">Expiry Date:</label>
        <input type="date" id="expiryDate" name="expiryDate" value="${prescriptionObj.expiryDate}" required>
        <br>
        
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${prescriptionObj.quantity}" required>
        <br>
        
        <button type="submit">Update Prescription</button>
    </form>
</body>
</html>
