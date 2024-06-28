document.addEventListener('DOMContentLoaded', function () {
    axios.get('http://localhost:8080/chart-info/loginCountByDay')
        .then(response => {
            const data = response.data;
            const ctx = document.getElementById('loginChart').getContext('2d');
            // 데이터 파싱
            const labels = data.map(item => item.ldt);
            const counts = data.map(item => item.count);

            // Chart.js 구성
            new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Daily Login Count',
                        data: counts,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1,
                        fill: false
                    },
                    {
                        label: 'Daily Login Count',
                        data: counts,
                        // borderColor: Utils.CHART_COLORS.yellow,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1,
                        type: 'line',
                        fill: false
                    },
                    {
                        label: 'Daily Login Count',
                        data: counts,
                        // borderColor: Utils.CHART_COLORS.orange,
                        borderColor: 'rgba(255, 159, 64), 1',
                        borderWidth: 1,
                        fill: true
                    }
                ]
                },
                options: {
                    scales: {
                        x: {
                            type: 'time',
                            time: {
                                parser: 'YYYY-MM-DD HH:mm:ss',
                                unit: 'day',
                                tooltipFormat: 'YYYY-MM-DD HH:mm:ss',
                                displayFormats: {
                                    day: 'YYYY-MM-DD'
                                }
                            },
                            title: {
                                display: true,
                                text: 'Date'
                            }
                        },
                        y: {
                            title: {
                                display: true,
                                text: 'Login Count'
                            },
                            beginAtZero: true
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching the login data:', error));
});