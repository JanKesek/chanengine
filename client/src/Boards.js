import React,{Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
class Boards extends Component {
    state={boards:null};
    async componentDidMount() {
        const url="http://34.68.138.17/jsfwar3";
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
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <ul className="navbar-nav mr-auto">
                    {this.state.boards.map((board) => {
                        return <li><Link to={`/boards/${board.id}`} className="nav-link"
                         > {board.name} </Link></li>
                    })}
                </ul>
                </nav>
            )}
            </div>
        )
    }
}

export default Boards;
