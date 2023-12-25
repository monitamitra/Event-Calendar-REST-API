import React, {useState} from "react";
import DatePicker from "react-datepicker";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import "./EventForm.css";

const UpdateEventForm = () => {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");
    
    const navigate = useNavigate();
    function deleteEvent() {
        axios.delete(`http://localhost:8080/api/${localStorage.getItem("userID")}/events/delete/${localStorage.getItem("eventID")}`)
        .then(() => {
            navigate("/calendar");
        });
    }

    function updateData() {
       axios
        .put(`http://localhost:8080/api/${localStorage.getItem("userID")}/events/${localStorage.getItem("eventID")}`
       ,{
              title, 
              description, 
              startDate, 
              endDate
       }).then(() => {
          navigate("/calendar");
       });
    }

    return (
        <form className="note-form">
        <input type="text" defaultValue={localStorage.getItem("eventTitle")} onChange={((e) => {setTitle(e.target.value)})} placeholder="Title" required />
        <textarea type="text"  onChange={((e) => {setDescription(e.target.value)})} placeholder="Description" rows={10} required />
        <DatePicker
            placeholderText="Start Date"
            showTimeSelect
            dateFormat="MMMM d, yyyy h:mmaa"
            selected={startDate}
            selectsStart
            startDate={startDate}
            endDate={endDate}
            onChange={date => setStartDate(date)}
            />
        <DatePicker
            placeholderText="End Date"
            showTimeSelect
            dateFormat="MMMM d, yyyy h:mmaa"
            selected={endDate}
            selectsEnd
            startDate={startDate}
            endDate={endDate}
            minDate={startDate}
            onChange={date => setEndDate(date)}
        />
        <button onClick={updateData}>Update Event</button>
        <button onClick={deleteEvent}>Delete Event</button>
      </form>

    )
}

export default UpdateEventForm;