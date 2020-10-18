import * as React from 'react';

export default function FilterRealEstate(props) {
    const { filter, realEstateTypeFilter } = props;

    return (
        <div className="form-inline">
            <label htmlFor="type">Real Estate Type:</label>
            <select name="type" onChange={(e) => props.setFilter(filter, e.target.value)} value={realEstateTypeFilter}>
                <option value="">All</option>
                <option value="APARTMENT_BUY">APARTMENT_BUY</option>
                <option value="APARTMENT_RENT">APARTMENT_RENT</option>
                <option value="HOUSE_BUY">HOUSE_BUY</option>
                <option value="HOUSE_RENT">HOUSE_RENT</option>
            </select>
            <label htmlFor="filter">
                <input
                    type="checkbox"
                    checked={filter}
                    onChange={() => props.setFilter(!filter, realEstateTypeFilter)}
                    id="filter"
                />
                Price between 400 EUR and 600 EUR
            </label>
        </div>
    );
}
