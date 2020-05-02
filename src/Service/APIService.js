import Axios from 'axios'


class ApiService {
    constructor() {
        this.preurl = "http://localhost:8080/";
    }

    post(url, data) {
        return Axios.post(this.preurl + url, data).then((response) => {
            return response.data

        }).catch((error) => {
            this.x = this.errorResponse();
        });



    }
    get(url) {
        return Axios.get(this.preurl + url).then((response) => {
            return response.data;
        }).catch((error) => {
            return this.errorResponse(error.response);
        });
    }

    errorResponse(error) {
        if (error.status === 401) {
            window.location.href = 'unAuthAccess'
        }
        else if (error.status === 404) {
            window.location.href = 'pageNotFound'
        }
        else if (error.status === 500) {
            window.location.href = 'sysAdminError'
        }
        else {
            console.log(error.data);
            return error.data;
        }

    }
}
const apiService = new ApiService();
export default apiService;