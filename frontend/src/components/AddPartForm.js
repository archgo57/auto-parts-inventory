import React, { useState } from 'react';

const AddPartForm = () => {
    const [part, setPart] = useState({
        name: '',
        description: '',
        quantity: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setPart({ ...part, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch('/api/parts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(part),
        });

        if (response.ok) {
            // Handle successful addition of part
            setPart({ name: '', description: '', quantity: '' });
            alert('Part added successfully!');
        } else {
            // Handle error
            alert('Failed to add part.');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Name:</label>
                <input
                    type="text"
                    name="name"
                    value={part.name}
                    onChange={handleChange}
                    required
                />
            </div>
            <div>
                <label>Description:</label>
                <input
                    type="text"
                    name="description"
                    value={part.description}
                    onChange={handleChange}
                    required
                />
            </div>
            <div>
                <label>Quantity:</label>
                <input
                    type="number"
                    name="quantity"
                    value={part.quantity}
                    onChange={handleChange}
                    required
                />
            </div>
            <button type="submit">Add Part</button>
        </form>
    );
};

export default AddPartForm;