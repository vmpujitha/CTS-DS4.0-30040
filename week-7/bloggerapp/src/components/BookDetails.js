const BookDetails = ({ books }) => {
  if (!books || books.length === 0) {
    return <p className="no-data">No books available</p>;
  }

  return (
    <div className="book-list">
      <ul>
        {books.map((book) => (
          <li key={book.id} className="book-item">
            <h3>{book.bname}</h3>
            <p className="price">Price: ₹{book.price}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookDetails;