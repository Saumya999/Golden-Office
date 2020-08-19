# Golden-Office
Customer Case management

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
    "agentId":"",
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
