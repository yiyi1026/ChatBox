import React from 'react'



export default function whatever(){
    function test() {
      console.log("test");
      return <div></div>
    }

    return (
      <div >
        <button onClick={test}>Click me</button>
      </div>
    );
}
