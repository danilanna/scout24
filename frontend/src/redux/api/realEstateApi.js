const host = process.env.REACT_APP_HOST;
const path = '/real-estate';
const basePath = host + path;

export default class RealEstateApi {

    static getRealEstateList(filter) {
        const url = basePath + '?filter=' + filter;
        return fetch(url).then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Something went wrong');
            }
        }).catch(error => {
            throw error;
        });
    }

    static saveRealEstate(realEstate) {
        return fetch(basePath, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(realEstate),
        })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Something went wrong');
                }
            })
            .catch((error) => {
                throw error;
            });
    }
}