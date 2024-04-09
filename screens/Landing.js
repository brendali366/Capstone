import { StyleSheet, Text, View, Button, Alert, Pressable } from 'react-native'

const Landing = () => {
    return(
        <View style={StyleSheet.container}>
            <Text> This is the landing page! Welcome!</Text>
            <Button style ={styles.buttonStyle} title="Welcome" onPress={() => Alert.alert('Welcome Button')} />
        </View>
    )
}

export default Landing

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});