import { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import { books, courses, blogContent } from './data';
import './App.css';

const App = () => {
  const [activeTab, setActiveTab] = useState('books');
  const [loading] = useState(false); // Removed setLoading since we're not using it

  const renderContent = () => {
    if (loading) {
      return <div className="loading-screen">Loading data...</div>;
    }

    switch (activeTab) {
      case 'books':
        return <BookDetails books={books} />;
      case 'blog':
        return <BlogDetails content={blogContent} />;
      case 'courses':
        return <CourseDetails courses={courses} />;
      default:
        return <BookDetails books={books} />;
    }
  };

  return (
    <div className="app">
      <h1 className="app-title">Blogger App</h1>
      
      <div className="tab-buttons">
        <button
          className={`tab-btn ${activeTab === 'books' ? 'active' : ''}`}
          onClick={() => setActiveTab('books')}
        >
          Book Details
        </button>
        <button
          className={`tab-btn ${activeTab === 'blog' ? 'active' : ''}`}
          onClick={() => setActiveTab('blog')}
        >
          Blog Details
        </button>
        <button
          className={`tab-btn ${activeTab === 'courses' ? 'active' : ''}`}
          onClick={() => setActiveTab('courses')}
        >
          Course Details
        </button>
      </div>

      <div className="content-container">
        {renderContent()}
      </div>

      <div className="status-bar">
        {activeTab === 'books' && <span>Showing {books.length} books</span>}
        {activeTab === 'blog' && <span>Showing {blogContent.posts.length} blog posts</span>}
        {activeTab === 'courses' && <span>Showing {courses.length} courses</span>}
      </div>
    </div>
  );
};

export default App;