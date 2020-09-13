import React, { useState } from "react";

import { View, Text, Button, StyleSheet, Dimensions } from "react-native";
import * as Animatable from "react-native-animatable";

const SplashView = ({ navigation }) => {
  const [modalVisible, setModalVisible] = useState(false);
  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Animatable.Image
          animation="bounceIn"
          source={require("../assets/logo.png")}
          style={styles.logo}
        />
      </View>
      <View style={styles.footer}>
        <Text style={styles.title}>Welcome to Octopus !</Text>
        <Text style={styles.text}>Stay connected to your customers</Text>
        <View style={styles.button}>
          <Button
            title="Get Started"
            onPress={() => navigation.navigate("AuthScreen")}
          />
        </View>
      </View>
    </View>
  );
};

export default SplashView;

const { height } = Dimensions.get("screen");
const height_logo = height * 0.28;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#ffffff",
  },
  header: {
    flex: 5,
    justifyContent: "center",
    alignItems: "center",
  },
  footer: {
    flex: 4,
    backgroundColor: "#3b2663",
    borderTopLeftRadius: 70,
    alignItems: "center",
    justifyContent: "center",
  },
  logo: {
    height: height_logo,
    width: height_logo,
  },
  title: {
    color: "white",
    fontSize: 30,
    fontWeight: "bold",
  },
  text: {
    color: "red",
    fontSize: 20,
    marginTop: 15,
  },
  button: {
    alignItems: "flex-end",
    marginTop: 30,
  },
  started: {
    width: 150,
    height: 40,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 50,
    flexDirection: "row",
  },
  textSign: {
    color: "white",
    fontWeight: "bold",
  },
});
