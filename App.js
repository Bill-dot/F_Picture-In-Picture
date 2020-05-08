import React, { Component } from 'react'
import { View, Text, StyleSheet, NativeModules, TouchableOpacity } from 'react-native'
import Video from 'react-native-video'
import { Dimensions } from 'react-native';

const { PIP } = NativeModules

// const {disableControls,onPause}= PIP

export default class App extends Component {
  constructor(props){
    super(props)
    this.state={
      controls:true,
      onPause:false,
      pipMode:false
    }
  }

  disableControls(){
    PIP.disableControls((val)=>{
      this.setState({...this.state, controls:val, pipMode:true})
      console.log(Dimensions.get('window').width)
      console.log(Dimensions.get('window').width * (9 / 16))

    })
  }

  onPause(){
    PIP.onPause((val)=>{
      console.log(val)
      this.setState({...this.state,onPause:val })
    })
  }

  // screenSize(val){
  //   if(!this.state.controls){
  //     return {width:null, height:null}
  //   }else{
  //     return{
  //       width: Dimensions.get('window').width,
  //       height: Dimensions.get('window').width * (9 / 16),
  //       backgroundColor: 'black',
  //     }
  //   }
  // }

  


  render() {
    

    return (
      <View style={{ flex: 1,
      justifyContent:'center' }}>
        
        {/* <Video source={require('./assets/Videos/Screen.mp4')}
          ref={(ref) => { this.player = ref }}
          style={styles.backgroundVideo}
          controls={this.state.controls}
          resizeMode={'cover'}
          onPause={this.state.onPause}
          playInBackground={true}
        /> */}
        <TouchableOpacity onPress={()=>{
          console.log('press')
          PIP.enterPIP()
          this.disableControls()
          this.onPause()
          }}>

          <Text style={styles.text}>PIP</Text>
        </TouchableOpacity>
        
      </View>
    )
  }
}

var styles = StyleSheet.create({
  backgroundVideo:
    {
      
      width: Dimensions.get('window').width,
      height: Dimensions.get('window').width * (9 / 16),
      backgroundColor: 'black',
    },
  text: {
    padding: 25,
    fontSize: 30,
    alignSelf:'center'
  }
});