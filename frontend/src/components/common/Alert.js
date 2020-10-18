import React from "react";

export default function Alert(props) {
    if (props.isError) {
        return (
            <div className="alert">
                <strong>Error!</strong> Something went wrong!
            </div>
        );
    } else if (props.isSaved) {
        return (
            <div className="alert alert-success">
                <strong>Success!</strong> Record saved successfully
            </div>
        );
    }
    return (<div/>);
}