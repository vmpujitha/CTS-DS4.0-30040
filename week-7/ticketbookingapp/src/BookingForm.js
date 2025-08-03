function BookingForm() {
  return (
    <div className="booking-form">
      <h2>Book Your Ticket</h2>
      <form>
        <div>
          <label>Flight Number: </label>
          <input type="text" />
        </div>
        <div>
          <label>Passenger Name: </label>
          <input type="text" />
        </div>
        <div>
          <label>Date: </label>
          <input type="date" />
        </div>
        <button type="submit">Confirm Booking</button>
      </form>
    </div>
  );
}

export default BookingForm;