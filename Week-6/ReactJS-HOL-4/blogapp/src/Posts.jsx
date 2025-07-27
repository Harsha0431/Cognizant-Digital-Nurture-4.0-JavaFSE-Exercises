import React from "react";
import Post from "./Post";

export default class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        }
    }

    async loadPosts() {
        try {
            const res = await fetch("https://jsonplaceholder.typicode.com/posts");
            if (!res.ok) throw new Error("Failed to fetch posts");
            const data = await res.json();
            this.setState({ posts: data });
        } catch (error) {
            alert("Error loading posts: " + error.message);
            console.error(error);
        }
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        return (
            <div>
                <h2>Posts Fetched from API ({this.state.posts.length})</h2>
                {
                    this.state.posts.length == 0 ? <p>No Posts found or fetched.</p>
                        :
                        <ul>
                            {
                                this.state.posts.map(post => <li key={post.id}>
                                    <h3>{post.title}</h3>
                                    <p>
                                        {post.body}
                                    </p>
                                </li>)
                            }
                        </ul>

                }
            </div>
        )
    }

    componentDidCatch(error, info) {
        alert(error.message);
        console.log(error);
        console.log(info);
    }
}