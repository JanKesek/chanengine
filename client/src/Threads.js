import React,{Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import Boards from './Boards';
import Posts from './Posts';

class Threads extends Component {
    state={threads:null};

    async componentDidMount() {
        console.log(this.props);
        const url=`http://34.68.138.17/jsfwar3${this.props.match.url}`;
        const response = await fetch(url);
        const data=await response.json();
        console.log(data);
        console.log(url);
        console.log(this.props.match.url);
        this.setState({threads: data})
    }
    
    render() {
        return (
            <div>
            {!this.state.threads ? (<div>loading...</div>) : (
                <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <ul className="navbar-nav mr-auto">
                    {this.state.threads.map((thread) => {
                        return <li><Link to={`${this.props.match.url}/${thread.id}`}
                        className="nav-link"> {thread.content} </Link></li>

                    })}
                </ul>
                </nav>
                </div>
            )}
            </div>

        )
    }

}
export default Threads;
