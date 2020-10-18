import * as React from 'react';
import { connect } from 'react-redux';
import {saveRealEstate} from "../../redux/actions/realEstateActions";
import Alert from "../common/Alert";

function RealEstate(props) {
    const { saveRealEstate, isFetching } = props;

    const handleSubmit = (event) => {
        event.preventDefault();
        const realEstate = {
            type: event.target.type.value,
            street: event.target.street.value,
            houseNumber: event.target.houseNumber.value,
            postcode: event.target.postcode.value,
            city: event.target.city.value,
            livingArea: event.target.livingArea.value,
            siteArea: event.target.siteArea.value,
            rentalPrice: event.target.rentalPrice.value,
            salesPrice: event.target.salesPrice.value,
            imageURL: event.target.imageURL.value,
        };
        saveRealEstate(realEstate);
    }

    if (isFetching) {
        return (<div>IS SAVING...</div>);
    } else {
        return (
            <div className="container">
                <Alert {...props}/>
                <h2>Create new Real Estate</h2>

                <form onSubmit={handleSubmit}>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">Real Estate Type:</label>
                        </div>
                        <div className="inputField">
                            <select name="type" required={true}>
                                <option value="APARTMENT_BUY">APARTMENT_BUY</option>
                                <option value="APARTMENT_RENT">APARTMENT_RENT</option>
                                <option value="HOUSE_BUY">HOUSE_BUY</option>
                                <option value="HOUSE_RENT">HOUSE_RENT</option>
                            </select>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">Address:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="street" required={true} maxLength={250}/>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">House Number:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="houseNumber" required={true} maxLength={250}/>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">Postcode:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="postcode" required={true}/>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">City:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="city" required={true} maxLength={250}/>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="type">Living Area:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="livingArea" required={true}/>
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="siteArea">Site Area:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="siteArea" />
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="rentalPrice">Rental Price:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="rentalPrice" />
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="salesPrice">Sales Price:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="salesPrice" />
                        </div>
                    </div>

                    <div className="row">
                        <div className="labelField">
                            <label htmlFor="imageURL">Image URL:</label>
                        </div>
                        <div className="inputField">
                            <input type="text" name="imageURL" maxLength={250}/>
                        </div>
                    </div>

                    <div className="row">
                        <input type="submit" value="Submit" />
                    </div>

                </form>
            </div>
        );
    }

}

const mapDispatchToProps = dispatch => {
    return {
        saveRealEstate: (realEstate) => dispatch(saveRealEstate(realEstate)),
    }
};

function mapStateToProps(state) {
    const {realEstate, isFetching, isError, isSaved} = state.realEstateReducer;
    return {
        realEstate,
        isFetching,
        isError,
        isSaved
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(RealEstate);