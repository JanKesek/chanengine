import React,{Component} from 'react';
import axios from 'axios';

class Posts extends Component {
    state={posts:null,username:null,content:null,imagefilename:null};
    async componentDidMount() {
        const url=`http://34.68.138.17/jsfwar3${this.props.match.url}`;
        const response = await fetch(url);
        const data=await response.json();
        console.log(data);
        console.log(url);
        this.setState({posts: data})
    }
    submitHandler = (e) => {
        e.preventDefault();
        let payload=null;
        const reader=new FileReader();
        this.state.post_time=new Date().toISOString().split('.')[0].split('T').join(' ');
        reader.onloadend = (async () => {
            this.state.imagefilename= reader.result;
            console.log("WHATEVER1");
            (() => {
                payload=Object.assign({},this.state)
                console.log("WHATEVER2")
            })();
            delete payload.posts;
            console.log("STATE: ", this.state);
            console.log("PAYLOAD: ",payload);
            await axios.post(`http://34.68.138.17/jsfwar3${this.props.match.url}`,payload)
                 .then((response)=> {
                     console.log(response);
                     //payload=Object.assign([],response.data)
                     },(error) => {console.log(error)}
            );
            //this.setState({posts:payload})
 
        })
        reader.readAsDataURL(document.getElementById("post-image").files[0]);
        //this.setState(this.state)
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
                            {post.imagefilename ? (<img src={`/images/${post.imagefilename}`}></img>):(<iv></iv>)}<p>{post.content}</p>
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
