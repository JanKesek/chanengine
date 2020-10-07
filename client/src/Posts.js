import React,{Component} from 'react';
import axios from 'axios';
class Posts extends Component {
    state={posts:null,username:null,content:null,imagefilename:null};
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
        reader.onloadend = () => this.state.imagefilename= reader.result;
        reader.readAsDataURL(document.getElementById("post-image").files[0]);
        this.state.post_time=new Date().toISOString().split('.')[0].split('T').join(' ');
        let payload=Object.assign({},this.state);
        delete payload.posts;
        console.log("STATE: ", this.state);
        console.log("PAYLOAD: ",payload);
        axios.post(`http://localhost:8080/jsfwar3${this.props.match.url}`,payload);
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
                <input type="text" name="content" value={this.state.content} 
                onChange={this.changeHandler}/>
                <p>IMAGE</p>
                <input type="file" name="imagefilename" id="post-image" value={this.state.imagefilename} 
                onChange={this.changeHandler}/>
                <button type="submit">Post</button>
            </form>
            </div>

        )
    }
}
export default Posts;