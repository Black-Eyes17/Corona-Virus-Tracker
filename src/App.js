import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Homepage from './Pages/HomePage';
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/" exact component={Homepage}/>
      </Router>
    </div>
  );
}

export default App;
