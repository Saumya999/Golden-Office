import { StatusBar } from "expo-status-bar";
import React, { Component } from "react";
import { Button, StyleSheet, Text, View } from "react-native";
import { createDrawerNavigator } from "@react-navigation/drawer";
import { NavigationContainer } from "@react-navigation/native";
import RootStackScreen from "./Screens/RootStackScreen";
import SplashScreen from "./Screens/SplashScreen";
function HomeScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Button
        onPress={() => navigation.navigate("Notifications")}
        title="Go to notifications"
      />
    </View>
  );
}

function NotificationsScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Button onPress={() => navigation.goBack()} title="Go back home" />
    </View>
  );
}

const Drawer = createDrawerNavigator();

class App extends Component {
  constructor() {
    super();
  }
  render() {
    return (
      <NavigationContainer>
        <RootStackScreen />
      </NavigationContainer>
    );
  }
}

export default App;
