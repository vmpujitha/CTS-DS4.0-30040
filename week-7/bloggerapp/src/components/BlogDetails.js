const BlogDetails = ({ content }) => {
  return !content ? (
    <p className="loading">Loading blog content...</p>
  ) : (
    <div className="blog-content">
      <h2>{content.title}</h2>
      {content.posts && content.posts.length > 0 ? (
        <ul>
          {content.posts.map((post, index) => (
            <li key={index}>{post}</li>
          ))}
        </ul>
      ) : (
        <p className="no-posts">No posts available</p>
      )}
    </div>
  );
};

export default BlogDetails;