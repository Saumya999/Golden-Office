### Golden-Office
# Customer Case management

### POST Create Case API : '/case/createCase'
Payload 

{
    "caseType": "Regular",
    "caseShortDescription": "Short Description Second",
    "caseLongDescription": "Long Description Second",
    "caseImportance" : "Critical",
    "customerEmail":"indra123@gmail.com"
}


### Post create Customer: '/customer/create'
Paylaod 
{
    "firstName":"Saumya",
    "lastName":"Sarkar",
    "email":"saumya123@gmail.com",
    "caseList":[],
    "password":"Martini"
}

### Post login Customer : '/customer/login'
Payload
{
     "email":"saumya123@gmail.com",
     "password":"Martini"
}

### GET get all customer API : '/customer/allCustomer'

### GET get all case API: '/case/allCases'

### GET get developers under any certain manager '/employee/getMyDeveloper/{managerID}'

### GET get all Developers '/employee/getAllDevelopers'

### GET get all managers '/employee/getAllManagers'

### POST assign a manager to a developer '/employee/assignManager/{managerId}'
Payload 
{
    "id": "Developer_2682020123227",
    "firstName":"Dev6",
    "lastName":"Dev6",
    "email":"dev6@gmail.com",
    "role":"Developer"
}

### POST create Team/WorkGroup with ManagerId  '/workGroup/createTeam'
Payload 
{
    "groupName":"Team-Durga",
    "groupDefinition":"UI-UX Design Team",
    "managerId":"Manager_2582020104920",
    "ticketIds": []
}
