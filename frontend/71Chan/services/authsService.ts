const API_BASE_URL = "http://localhost:8080/api";
   export const register =  async (user:any) => {
        const response = await fetch(`${API_BASE_URL}/register`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user),
        });

        if (!response.ok) {
            throw new Error("Failed to register");
        }

        console.log(response.json());
        return response.text(); 
    }

    export const login = async (credentials:any) => {
        const response = await fetch(`${API_BASE_URL}/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(credentials),
        });

        if (!response.ok) {
            throw new Error("Invalid credentials");
        }

        return response.text();
    }

