import React, { Component } from "react";

import { createStackNavigator } from "@react-navigation/stack";
import SplashView from "./SplashScreen";
import RegistrationView from "./CustomerRegister";
import AuthScreen from "./AuthScreen";

const RootStack = createStackNavigator();

class RootStackView extends Component {
  constructor() {
    super();
  }
  render() {
    return (
      <RootStack.Navigator headerMode="none">
        <RootStack.Screen name="SplashScreen" component={SplashView} />
        <RootStack.Screen name="AuthScreen" component={AuthScreen} />
        <RootStack.Screen
          name="RegistrationScreen"
          component={RegistrationView}
        />
      </RootStack.Navigator>
    );
  }
}

export default RootStackView;
