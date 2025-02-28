import React, { useState } from 'react';

const SearchFilter = ({ onSearch }) => {
    const [searchTerm, setSearchTerm] = useState('');

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
        onSearch(event.target.value);
    };

    return (
        <div className="search-filter">
            <input
                type="text"
                placeholder="Search parts..."
                value={searchTerm}
                onChange={handleSearchChange}
            />
        </div>
    );
};

export default SearchFilter;