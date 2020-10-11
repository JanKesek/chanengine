import React,{Component} from 'react';
import {HashRouter as Router, Route, Link} from 'react-router-dom';
//import {browserHistory} from 'react-router';
import Posts from './Posts';
import Threads from './Threads';
import Boards from './Boards';
class App extends Component {
    state={boards:null};
    render() {
        return (
            <div>
            <Router>
                <li><Link onClick={()=> this.forceUpdate()} to="/boards" className="nav-link"> WELCOME </Link></li>
                   
                    <Route path="/boards" exact strict 
                        render={(props)=> <Boards {...props} 
                        key={Math.random()}/>  } />
                    <Route path="/boards/:id" exact strict 
                        render={(props)=> <Threads {...props} 
                        key={Math.random()} /> } />
                    <Route path="/boards/:id/:id2" exact strict 
                        render={(props)=> <Posts {...props} 
                        key={Math.random()}/> } />
            </Router>
            </div>
        )
    }
}

export default App;
