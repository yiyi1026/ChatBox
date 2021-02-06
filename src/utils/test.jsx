import React from 'react'
import SockJsClient from 'react-stomp'



export default function whatever(){
    let clientRef

    function test() {
      console.log("test");
      console.log(clientRef)
      clientRef.sendMessage('/app/Channel1', '{"name":"frontUser1", "message":"message2"}');
    }

    function search() {
          console.log("search");
          var FetchStream = require("fetch").FetchStream;

          fetch('http://192.168.1.6:8901/api/message?channel=Channel1')
            .then(response => response.json())
            .then(data => console.log(data));
    //         .catch((error) => {
    //           console.error('Error:', error);
    //             });
     }

    return (
      <div >
        <button onClick={test}>Click me</button>
        <button onClick={search}>search</button>
        <SockJsClient url='http://localhost:8901/chatbox-websocket' topics={['/channel/Channel1']}
                    onMessage={(msg) => { console.log(msg); }}
                    ref={ (client) => { clientRef = client }} />
      </div>
    );
}
