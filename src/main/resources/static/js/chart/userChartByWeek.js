document.addEventListener('DOMContentLoaded', function () {
    // axios 요청들을 병렬로 처리하여 모든 데이터를 가져옴
    axios.all([
        axios.get('http://localhost:8080/api/chart/users/login-count/week'),
        axios.get('http://localhost:8080/api/chart/users/register-count/week'),
        axios.get('http://localhost:8080/api/chart/users/unregister-count/week'),
        axios.get('http://localhost:8080/api/chart/users/deactivate-count/week')
    ])
    .then(axios.spread((loginResponse, registerResponse, unregisterResponse, deactivateResponse) => {
        // 각 API에서 받은 데이터를 변수에 저장
        const loginData = loginResponse.data;
        const registerData = registerResponse.data;
        const unregisterData = unregisterResponse.data;
        const deactivateData = deactivateResponse.data;

        // 데이터를 시간 순서대로 정렬
        loginData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        registerData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        unregisterData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));
        deactivateData.sort((a, b) => new Date(a.chartTime) - new Date(b.chartTime));


        const labels = loginData.map(item => item.chartTime);

        const loginCounts = loginData.map(item => item.activeCount);
        const registerCounts = registerData.map(item => item.activeCount);
        const unregisterCounts = unregisterData.map(item => item.activeCount);
        const deactivateCounts = deactivateData.map(item => item.activeCount);

        // Chart.js 구성
        const ctx = document.getElementById('userChartByWeek').getContext('2d');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: labels,
                datasets: [
                    {
                        label: 'Login',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        data: loginCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Register',
                        backgroundColor: 'rgba(192, 75, 192, 0.2)',
                        borderColor: 'rgba(192, 75, 192, 1)',
                        data: registerCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Unregister',
                        backgroundColor: 'rgba(192, 192, 75, 0.2)',
                        borderColor: 'rgba(192, 192, 75, 1)',
                        data: unregisterCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    },
                    {
                        label: 'Deactivate',
                        backgroundColor: 'rgba(75, 75, 192, 0.2)',
                        borderColor: 'rgba(75, 75, 192, 1)',
                        data: deactivateCounts,
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    }
                ]
            },
            options: {
                scales: {
                    x: {
                        type: 'time',
                        time: {
                            parser: 'YYYY-MM-DDTHH:mm:ss',
                            unit: 'hour',
                            tooltipFormat: 'YYYY-MM-DDTHH:mm',
                            displayFormats: {
                                hour: 'HH:mm'
                            }
                        },
                        title: {
                            display: true,
                            text: '7Days'
                        },
                        ticks: {
                            source: 'data',
                            autoSkip: false
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'User'
                        },
                        beginAtZero: true
                    }
                }
            }
        });
    }))
    .catch(error => console.error('Error fetching the data:', error));
});