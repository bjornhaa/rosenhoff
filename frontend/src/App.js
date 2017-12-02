import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="app">
          <div className="menu">
              <div className="menuElement">A-lag</div>
              <div className="menuElement">Oldboys</div>
              <div className="menuElement">Inline</div>
          </div>
          <div className="subMenu">
              <div className="menuElement">Aktivitet</div>
              <div className="menuElement">Toppscorer</div>
          </div>
          <div>
              body
          </div>
      </div>
    );
  }
}

export default App;
