import React,{Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';

class Posts extends Component {
    state={boards:null,username:'',postcontent:'',postfilename:''};
    async componentDidMount() {
        const url=`http://localhost:8080/jsfwar3${this.props.match.url}`;
        const response = await fetch(url);
        const data=await response.json();
        console.log(data);
        console.log(url);
        this.setState({posts: data})
    }
    submitHandler = (e) => {
        e.preventDefault();
        const reader=new FileReader();
        reader.onloadend = () => this.state.postfilename= reader.result;
        reader.readAsDataURL(document.getElementById("post-image").files[0]);
        console.log(this.state);
    }
    changeHandler=(e) => this.setState({[e.target.name]: e.target.value})
    render() {
        return (
            <div>
            {!this.state.posts ? (<div>loading...</div>) : (
                <div class="post-data">
                    <ul className="navbar-nav mr-auto">
                        {this.state.posts.map((post) => {
                            return (
                                <div>
                            <h1>{post.username} {post.post_time} {post.id}  </h1>
                            {post.imagefilename ? (<img src={`../${post.imagefilename}`}></img>):(<iv></iv>)}<p>{post.content}</p>
                                </div>
                            )

                        })}
                
                    </ul>
                </div>
            )}
            <form onSubmit={this.submitHandler} >
                <p>USERNAME</p>
                <input type="text" name="username" value={this.state.username} 
                onChange={this.changeHandler}/>
                <p>POST</p>
                <input type="text" name="postcontent" value={this.state.postcontent} 
                onChange={this.changeHandler}/>
                <p>IMAGE</p>
                <input type="file" name="postfilename" id="post-image" value={this.state.postfilename} 
                onChange={this.changeHandler}/>
                <button type="submit">Post</button>
            </form>
            </div>

        )
    }
}
export default Posts;