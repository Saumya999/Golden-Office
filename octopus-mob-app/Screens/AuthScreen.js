import React, { Component } from "react";
import { View, Text, StyleSheet } from "react-native";
import { Form, Input, Item, CheckBox, Body, Button } from "native-base";
import FontAwesome from "react-native-vector-icons/FontAwesome";
import Feather from "react-native-vector-icons/Feather";

class AuthScreen extends Component {
  constructor() {
    super();
  }
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.top}></View>
        <View style={styles.middle}>
          <Text style={styles.textContainer}>Login to Octopus System</Text>
          <View style={styles.formArea}>
            <Text style={[styles.textContainer, styles.SignIn]}>Login</Text>
            <Form>
              <Item style={styles.formItems}>
                <FontAwesome name="user-o" color="#05375a" size={20} />
                <Input placeholder="Username" style={styles.Input} />
                <Feather name="check-circle" color="green" size={20} />
              </Item>
              <Item style={styles.formItems}>
                <FontAwesome name="lock" color="#05375a" size={20} />
                <Input placeholder="Password" style={styles.Input} />
                <Feather name="eye-off" color="grey" size={20} />
              </Item>
              <View style={styles.loginAs}>
                <Text style={styles.loginText}>Login as</Text>
                <CheckBox checked={true} />
                <Body>
                  <Text style={styles.cboxText}>Agent</Text>
                </Body>
                <CheckBox checked={false} />
                <Body>
                  <Text style={styles.cboxText}>Client</Text>
                </Body>
              </View>
              <View style={styles.Button}>
                <Button block style={styles.mainbtn}>
                  <Text style={styles.btnText}>Submit</Text>
                </Button>
              </View>
            </Form>
          </View>
        </View>
        <View style={styles.bottom}></View>
      </View>
    );
  }
}

export default AuthScreen;

const styles = StyleSheet.create({
  mainbtn: {
    backgroundColor: "#1DDCAF",
  },
  btnText: {
    color: "#2d3057",
  },
  Button: {
    padding: 30.8,
    borderRadius: 4,
  },
  cboxText: {
    fontSize: 10,
  },
  loginText: {
    color: "#2d3057",
    fontSize: 15,
    fontWeight: "bold",
  },
  container: {
    flex: 1,
    position: "relative",
  },
  top: {
    position: "relative",
    backgroundColor: "#5752f2",
    paddingLeft: 12.7,
    paddingRight: 12.7,
    height: 250,
  },
  middle: {
    width: "100%",
    height: "100%",
    flex: 1,
    position: "absolute",
    zIndex: 2,
    backgroundColor: "transparent",
    paddingRight: 26.3,
    paddingLeft: 26.3,
  },
  bottom: {
    position: "relative",
    paddingLeft: 12.7,
    paddingRight: 12.7,
    height: "100%",
    backgroundColor: "#5752f2",
  },
  formArea: {
    alignSelf: "center",
    backgroundColor: "#ffffff",
    width: "100%",
    top: "20%",
    paddingBottom: 40,
    borderRadius: 20,
  },
  textContainer: {
    color: "#fcfdff",
    marginBottom: 30,
    fontSize: 24,
    position: "relative",
    top: "20%",
    alignSelf: "center",
  },
  mainForm: {},
  formItems: {
    marginTop: 15,
    paddingRight: 20,
  },
  Input: {},
  SignIn: {
    top: 0,
    color: "#2d3057",
    margin: 15,
  },
  loginAs: {
    marginTop: 18,
    display: "flex",
    flexDirection: "row",
    marginBottom: 20,
    alignItems: "center",
    paddingLeft: 46.6,
  },
});
