import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    async loadPosts() {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            if (!response.ok) {
                throw new Error('Failed to fetch posts');
            }
            const data = await response.json();
            const posts = data.map(post => new Post(post.id, post.title, post.body));
            this.setState({ posts });
        } catch (error) {
            this.setState({ error: error.message });
        }
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert(`Error: ${error}\nComponent Stack: ${info.componentStack}`);
        this.setState({ error: error.message });
    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <div className="error">Error: {error}</div>;
        }

        if (!posts.length) {
            return <div className="loading">Loading posts...</div>;
        }

        return (
            <div className="posts-container">
                <h1>Blog Posts</h1>
                {posts.map(post => (
                    <div key={post.id} className="post">
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;