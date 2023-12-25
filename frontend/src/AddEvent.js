import React, {useState} from "react";
import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "./EventForm.css";

const AddEventForm = () => {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    function addEvent() {
        axios.post(`http://localhost:8080/api/${localStorage.getItem("userID")}/events/create`, {
            title, 
            description, 
            startDate, 
            endDate
        }).then((res) => {
            console.log(res.data)
        })
    }

    return (
              <form className="note-form">
                <input type="text" value={title} onChange={((e) => {setTitle(e.target.value)})} placeholder="Title" required />
                <textarea type="text" value={description} onChange={((e) => {setDescription(e.target.value)})} placeholder="Description" rows={10} required />
                <DatePicker
                    placeholderText="Select Start Date"
                    showTimeSelect
                    dateFormat="MMMM d, yyyy h:mmaa"
                    selected={startDate}
                    selectsStart
                    startDate={startDate}
                    endDate={endDate}
                    onChange={date => setStartDate(date)}
                    />
                <DatePicker
                    placeholderText="Select End Date"
                    showTimeSelect
                    dateFormat="MMMM d, yyyy h:mmaa"
                    selected={endDate}
                    selectsEnd
                    startDate={startDate}
                    endDate={endDate}
                    minDate={startDate}
                    onChange={date => setEndDate(date)}
                />
                <button onClick={addEvent}>Add Event</button>
              </form>
          );
}

export default AddEventForm