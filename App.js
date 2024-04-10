import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View, Button, Alert, Pressable } from 'react-native';


const Separator = () => <View style={styles.separator} />;

export default function App() {
  return (
    <View style={styles.container}>
      <Text style = {styles.titleText}>This is Learning Kids!</Text>

      <View style={styles.logIn}>
        <Button title="Log In" onPress={() => Alert.alert('Button for logging in.')} /> 
        </View>
      <Separator />
      <View style={styles.signUp}>
      <Button style ={styles.buttonStyle} title="Sign Up" onPress={() => Alert.alert('Button for signing up.')} />
      </View>
      <StatusBar style="auto" />
    </View>
  );
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    //color: '#CC3259',
    alignItems: 'center',
    justifyContent: 'center',
  },

  titleText: {
    fontWeight: 'bold',
    color: '#CC3259',
    fontSize: 30,
  },

  buttonStyle:{
    backgroundColor:'#2159FD',
    color: '#000000',
  },

  logIn:{
    padding:2,
  },


  //idk if this doesn anything leaving it for now
  signUp: {
    backgroundColor: '#fff',
    color: '#000000',
    padding: 2,
  },

  
});
