import React,{Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';

class Posts extends Component {
    componentDidUpdate() {
       // location.reload();
    }
    render() {
        return (
            <div>   
                <h>Hello from POSTS</h>
            </div>
        )
    }

}
export default Posts;