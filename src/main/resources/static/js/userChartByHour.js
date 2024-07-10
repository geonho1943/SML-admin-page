document.addEventListener('DOMContentLoaded', function () {
    axios.get('http://localhost:8080/chart-info/loginCountByHour')
        .then(response => {
            const data = response.data;
            const ctx = document.getElementById('loginChartByHour').getContext('2d');
            const labels = data.map(item => item.ldt);
            const counts = data.map(item => item.count);
            // Chart.js 구성
            new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Hour Login Count',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        data: counts,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1,
                        tension: 0.3,
                        fill: false
                    }
                ]},
                options: {
                    scales: {
                        x: {
                            type: 'time',
                            time: {
                                parser: 'YYYY-MM-DD HH:mm:ss',
                                unit: 'hour',
                                tooltipFormat: 'YYYY-MM-DD HH:mm',
                                displayFormats: {
                                    hour: 'HH:ss'
                                }
                            },
                            title: {
                                display: true,
                                text: 'Time'
                            },
                            ticks: {
                                source: 'data',  // 데이터 소스 기반으로 틱 표시
                                autoSkip: false, // 자동 건너뛰기 비활성화
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