<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
	integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		
		var currentIndex = 1;
		
		 $("#addRowBtn").click(function () {
             var newRow = $("<tr>");
             newRow.append('<td><input type="text" name="userExperiences[' + currentIndex + '].noOfYears" /></td>');
             newRow.append('<td><input type="text" name="userExperiences[' + currentIndex + '].companyName" /></td>');
             newRow.append('<td><input type="text" name="userExperiences[' + currentIndex + '].description" /></td>');
             newRow.append('<td><button type="button" class="removeRowBtn">Remove</button></td>');
             $("#experienceTable").append(newRow);
             currentIndex++;
         });

         // Remove dynamic row
         $(document).on("click", ".removeRowBtn", function () {
             $(this).closest("tr").remove();
         });

		onloadChangeCountryStatus();
		function onloadChangeCountryStatus() {

			var val = ${initParam.selectedCountryId};
			alert(val);
			$("#countryId").val(val).change();

		};

		/* $("#countryId option:not(:selected)").hide(); */
		$("#countryId").change(function() {
			let countryId = $("#countryId").val();
			alert("k" + countryId);
			getStates(countryId);

		});

		function onload() {
			let countryId = $("#countryId").val();
			getStates(countryId);
		}
		onload();
		function getStates(countryId) {
			
			$.ajax({
				url : "getState",
				type : "GET",
				data : {
					id : countryId
				},
				dataType : "json",
				success : function(data) {
					$("#stateId").empty();
					$.each(data, function(index, country) {
						$("#stateId").append($('<option>', {
							value : country.stateId,
							text : country.stateName
						}));
					});

				},
				error : function(error) {
					console.error("Error:", error);
				}
			});
		}
		;
	});
</script>
<body>
	<h2>Hello World!</h2>

	<form:form modelAttribute="userRequest" method="post" action="save">

	
 
        
    
     Enter Emial iD;
    <form:input path="emailId" type="email"
			placeholder="Enter email address" />
		<form:errors path="emailId" />
		<br>
		<br>
		<br>
    ENter Pass word::
    <form:password path="password" placeholder="Enter password" />
		<form:errors path="password" />
		<br>
		<br>
		<br>
    F NAME
    <form:input path="firstName" placeholder="Enter first name" />
    <form:errors path="firstName" />
		<br>
		<br>
		<br>
    LNAME
    <form:input path="lastName" placeholder="Enter last name" />
    <form:errors path="lastName" />
		<br>
		<br>
		<br>
    Mobile
    <form:input path="mobileNuber" type="tel"
			placeholder="Enter mobile number" />
	<form:errors path="mobileNuber"  />
		<br>
		<br>
		<br>
    City
    <form:input path="cityName" placeholder="Enter city name" />
    <form:errors path="cityName" />
		<br>
		<br>
		<br>
    country
   
   <form:select path="countryId">
			<c:forEach var="country" items="${country}">
				<form:option value="${country.countryId}"
					label="${country.countryName}"></form:option>
			</c:forEach>
			


		</form:select>
		<form:errors path="countryId"/>
		<br><br>
				<br>
State SELECT ::
 <form:select path="stateId">
</form:select>
<form:errors path="stateId"/>
<br><br>

<c:forEach var="j" items="${masterLanguage}">
	<form:checkbox path="languageId"  value="${j.languageId}" label="${j.language}"/>
</c:forEach>

<br><br>	
	Choose User Type:::
	<c:forEach items="${userType}" var="i">
		<form:radiobutton path="userTypeId" value="${i.userTypeId }" label="${i.userType }"/>
	</c:forEach>
	
	<form:errors path="userTypeId"/>
		<br>
		<br>
		<table id="experienceTable">
		
		
		
		  <c:forEach items="${userRequest.userExperiences}" var="experience" varStatus="status">
                   
                            <td>Years</td>
                            <td><form:input type="number" path="userExperiences[${status.index}].noOfYears" /></td>
                            <td><form:errors path="userExperiences[${status.index}].noOfYears" cssClass="error" /></td>
                            <td>Company Name:</td>
                          	<td><form:input path="userExperiences[${status.index}].companyName" /></td>
                            <td><form:errors path="userExperiences[${status.index}].companyName" cssClass="error" /></td>
                            <td>Description</td>
                            <td><form:input path="userExperiences[${status.index}].description" /></td>
                            <td><form:errors path="userExperiences[${status.index}].description" cssClass="error" /></td>
                            
                        
                </c:forEach>
             </table>   
                 <button type="button" id="addRowBtn">Add Experience</button>

		<button type="submit">Submit</button>
	</form:form>
	
	

	


</body>
</html>
