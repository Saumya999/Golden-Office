import React from 'react';
import {Switch, Route} from 'react-router';
import './App.css';
import 'semantic-ui-css/semantic.min.css'
import Registration from './Components/Registration/createCustomerView';
import Login from './Components/Login/loginFormView';
import Admin from './Components/Admin/adminView';

function App() {
  return (
    <div className="App">
      <Switch>
        <Route exact path='/' component={Login}/>
        <Route eaxct path='/register' component={Registration} />
        <Route exact path='/adminPanel' component={Admin} />
      </Switch>
    </div>
  );
}

export default App;
