document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('searchChartForm');

    if (form) {
        form.addEventListener('submit', function (e) {
            e.preventDefault();

            // 사용자가 선택한 옵션들을 가져옵니다.
            const domain = document.getElementById('domainSelect').value;
            const chartType = document.getElementById('chartTypeSelect').value;
            const endTime = document.getElementById('endTimeInput').value;
            const objectIdx = document.getElementById('objectIdxInput').value;

            // URI 생성
            let url = `http://localhost:8080/api/chart/search/${domain}/${chartType}?objectIdx=${objectIdx}`;
            if (endTime) {
                url += `&endTime=${encodeURIComponent(endTime)}`;
            }
            console.log("Generated URI:", url);

            // API 요청
            axios.get(url)
                .then(response => {
                    const data = response.data;
                    renderChart(data, chartType);
                })
                .catch(error => {
                    console.error('차트를 가져오는 중 오류가 발생했습니다:', error);
                });
        });
    } else {
        console.error('searchChartForm ID를 가진 폼 요소를 찾을 수 없습니다.');
    }
});

function renderChart(data, chartType) {
    const ctx = document.getElementById('searchChartResult').getContext('2d');

    // 차트가 이미 존재하면 파괴하고 새로운 차트를 생성
    if (window.myChart) {
        window.myChart.destroy();
    }

    // X축 레이블 (날짜 또는 시간)
    const labels = Object.keys(data);

    // 도메인별로 데이터를 분류하여 datasets을 생성
    const datasets = [];
    const domains = new Set();

    // 데이터 구조 탐색
    labels.forEach(label => {
        const innerMap = data[label];
        Object.keys(innerMap).forEach(domain => {
            if (!domains.has(domain)) {
                domains.add(domain);
                datasets.push({
                    label: domain,
                    data: Array(labels.length).fill(0), // 기본적으로 0으로 채워진 배열
                    borderColor: getRandomColor(),
                    backgroundColor: 'rgba(0,0,0,0)', // 투명하게 설정
                    fill: false
                });
            }
        });
    });

    // 데이터 날자 채우기
    labels.forEach((label, index) => {
        const innerMap = data[label];
        Object.keys(innerMap).forEach(domain => {
            const dataset = datasets.find(d => d.label === domain);
            dataset.data[index] = innerMap[domain];
        });
    });

    // 차트 생성
    window.myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels, // X축 레이블: 날짜 또는 시간
            datasets: datasets // Y축 데이터: 각 도메인별 카운트 데이터
        },
        options: {
            scales: {
                x: {
                    type: 'time',
                    time: {
                        unit: chartType === 'day' ? 'hour' : 'day'
                    }
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

// 랜덤 색상을 생성하는 함수 (데이터셋의 색상을 다르게 하기 위해)
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}