import React,{Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import Posts from './Posts';
import Threads from './Threads';
import Boards from './Boards';
class App extends Component {
    state={boards:null};
    async componentDidMount() {
        const url="http://localhost:8080/jsfwar3/";
        const response = await fetch(url);
        const data=await response.json();
        console.log(data);
        console.log(url);
        this.setState({boards: data})
    }
    render() {
        return (
            <div>
            {!this.state.boards ? (<div>loading...</div>) : (
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
            )}
            </div>
        )
    }
}

export default App;